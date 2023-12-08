package com.sibertech.toDoList.mapper;

import com.sibertech.toDoList.model.DTO.ToDoListForGetDTO;
import com.sibertech.toDoList.model.enteties.ToDoListModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ToDoListMapper {
    private final ModelMapper modelMapper;

    public List<ToDoListForGetDTO> toToDoListDTOList(List<ToDoListModel> toDoListModelList)
    {
        List<ToDoListForGetDTO> toDoListForGetDTOList = new ArrayList<>();

        for(ToDoListModel toDoListModel : toDoListModelList)
        {
            ToDoListForGetDTO oneToDoListDTO = modelMapper.map(toDoListModel, ToDoListForGetDTO.class);
            toDoListForGetDTOList.add(oneToDoListDTO);
        }
        return toDoListForGetDTOList;
    }

}
