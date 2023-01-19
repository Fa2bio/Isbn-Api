package com.github.fa2bio.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.fa2bio.api.model.VolumeInfoModel;
import com.github.fa2bio.domain.model.VolumeInfo;

@Component
public class VolumeInfoAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public VolumeInfoModel toModel(VolumeInfo volumeInfo) {
		return modelMapper.map(volumeInfo, VolumeInfoModel.class);
	}
}
