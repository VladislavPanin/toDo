package com.sibertech.toDoList.service;

import com.sibertech.toDoList.mapper.ToDoListMapper;
import com.sibertech.toDoList.model.DTO.ToDoListForGetDTO;
import com.sibertech.toDoList.model.enteties.ToDoListModel;
import com.sibertech.toDoList.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoListServiceImpl implements ToDoListService {

    private final ToDoListRepository toDoListRepository;

    private final ToDoListMapper toDoListMapper;

    public String createTask(ToDoListModel toDoListModel)
    {
        String answer;
        ToDoListModel toDolist = toDoListModel;
        String name = toDolist.getName();
        String description = toDolist.getDescription();
        if(!name.equals("") && !description.equals("")) {
            toDoListRepository.save(toDoListModel);
            answer = "complete";
            return answer;
        }
        else{
            answer = "not complete";
            return answer;
        }
    }

    public List<ToDoListForGetDTO> getAllTasks(){
         List<ToDoListModel> toDoListModels = new ArrayList<>();
         toDoListModels = toDoListRepository.findAll();

         List<ToDoListForGetDTO> toDoListForGetDTOList = new ArrayList<>();
         toDoListForGetDTOList = toDoListMapper.toToDoListDTOList(toDoListModels);

         return toDoListForGetDTOList;
    }


    public List<ToDoListModel> getAllTasksModel(){


        return toDoListRepository.findAll();
    }

    public String updateTask(ToDoListModel toDoListModel, Integer toDoListId){
        //Наш юзер редактирует задачу тыкая на задачу на фронте, и фронт отдает ему id. Следовательно он не может накосячить с id
        String answer;
        ToDoListModel toDolist = toDoListModel;
        String name = toDolist.getName();
        String description = toDolist.getDescription();
        boolean isCompleted = toDolist.isCompleted();
            if(!name.equals("") && !description.equals("")) {


                ToDoListModel toDoListModelForBd = toDoListRepository.findByToDoListId(toDoListId);
                toDoListModelForBd.setName(toDoListModel.getName());
                toDoListModelForBd.setDescription(toDoListModel.getDescription());
                toDoListModelForBd.setCompleted(toDoListModel.isCompleted());
                toDoListRepository.save(toDoListModelForBd);


                answer = "complete";
                return answer;
            }
            else if(!name.equals("")) {

                ToDoListModel toDoListModelForBd = toDoListRepository.findByToDoListId(toDoListId);
                toDoListModelForBd.setName(toDoListModel.getName());
                toDoListModelForBd.setCompleted(toDoListModel.isCompleted());
                toDoListRepository.save(toDoListModelForBd);



                answer = "complete";
                return answer;
            }
            else if(!description.equals("")) {
                ToDoListModel toDoListModelForBd = toDoListRepository.findByToDoListId(toDoListId);
                toDoListModelForBd.setDescription(toDoListModel.getDescription());
                toDoListModelForBd.setCompleted(toDoListModel.isCompleted());
                toDoListRepository.save(toDoListModelForBd);


                answer = "complete";
                return answer;
            }else{
                answer = "not complete";
                return answer;
            }


    }

    public String deleteTask(Integer toDoListId){
        toDoListRepository.deleteByToDoListId(toDoListId);
        return "deleting complete";
    }



}
