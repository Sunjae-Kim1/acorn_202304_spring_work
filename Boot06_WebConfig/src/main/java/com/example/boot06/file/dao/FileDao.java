package com.example.boot06.file.dao;

import java.util.List;
import com.example.boot06.file.dto.FileDto;

public interface FileDao {
	public void insert(FileDto dto);
	public FileDto getData(int num);
	public void delete(int num);
	public List<FileDto> getList(FileDto dto);
	public int getCount(FileDto dto);
}