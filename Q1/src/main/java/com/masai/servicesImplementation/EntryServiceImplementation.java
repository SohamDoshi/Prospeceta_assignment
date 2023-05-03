package com.masai.servicesImplementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.ResourceNotFoundException;
import com.masai.modeldto.EntryDetailsResponseDto;
import com.masai.modeldto.EntryResponseDto;
import com.masai.models.Entry;
import com.masai.payloads.ApiResponse;
import com.masai.repositories.EntryRepo;
import com.masai.services.EntryServices;

@Service
public class EntryServiceImplementation implements EntryServices {

	@Autowired
	private EntryRepo entryRepo;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public ApiResponse saveEntry(Entry entry) throws ResourceNotFoundException {

		Entry api = entryRepo.findByApi(entry.getApi())
				.orElseThrow(() -> new ResourceNotFoundException("Entry", "API", entry.getApi()));

		EntryDetailsResponseDto entryDetailsResponseDto = toEntryDetailsResponseDto(entry);

		return new ApiResponse(LocalDateTime.now(), "Entry saved successfully!", true, entryDetailsResponseDto);
	}

	@Override
	public List<EntryResponseDto> getAllEntries() {

		List<Entry> list = entryRepo.findAll();

		return list.stream().map(e -> toEntryResponseDto(e)).collect(Collectors.toList());

	}

	private EntryDetailsResponseDto toEntryDetailsResponseDto(Entry entry) {

		return modelmapper.map(entry, EntryDetailsResponseDto.class);

	}

	private EntryResponseDto toEntryResponseDto(Entry entry) {

		return modelmapper.map(entry, EntryResponseDto.class);
	}

}
