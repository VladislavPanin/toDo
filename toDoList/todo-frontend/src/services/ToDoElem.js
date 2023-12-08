
import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';
import{ ServiceToDelete } from './Service';
import { ServiceToUpdate } from './ServiceToUpdate';
import { API } from '../Api/Api';



export default function ToDoElem(props) {

  const handleToUpdate=(e)=>{
    ServiceToUpdate(props.task.toDoListId, name, description, completed)

  .then(()=>{
     props.setTasks([])
    fetch("http://localhost:8080/toDoList/seeAllTasks")
    .then(res=>res.json())
    .then((result)=>{
    props.setTasks(result);
  })
    console.log("New task added")
  })
}


const handleToDelete=(e)=>{
  ServiceToDelete(props.task.toDoListId)

.then(()=>{
  fetch("http://localhost:8080/toDoList/seeAllTasks")
  .then(res=>res.json())
  .then((result)=>{
  props.setTasks(result);
})
  console.log("New deleted")
})
}

    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    

    const currencies = [
      {
        value: 'true',
        label: 'V',
      },
      {
        value: 'false',
        label: 'X',
      },
    ];



    const[name,setName]=useState('')
    const[description,setDescription]=useState('')
    const[completed,setCompleted]=useState('')
    const[tasks,setTasks]=useState([])

    useEffect(()=>{
      fetch("http://localhost:8080/toDoList/seeAllTasks")
        .then(res=>res.json())
        .then((result)=>{
          setTasks(result);
 
        }
    )
    
  },[])
  console.log(props)
        return (
        <Container>
           
        <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={props.task.toDoListId} >
         

         <TextField id="outlined-basic" label={props.task.name} variant="outlined" fullWidth 
          value={name}
          onChange={(e)=>setName(e.target.value)}
          />
          <br></br>
         <br></br>
          <TextField id="outlined-basic" label={props.task.description} variant="outlined" fullWidth
          value={description}
          onChange={(e)=>setDescription(e.target.value)}
          />
          {/* <br></br>
         <br></br>
          Статус выполнения: {completed ? 'выполненно' : 'не выполненно'}
         <br></br>
         <br></br>
          <TextField id="outlined-basic" select
          label="Select"
          defaultValue="false" 
          variant="outlined" fullWidth
          value={completed}
          onChange={(e)=>setCompleted(e.target.value)}
          >
        {currencies.map((option) => (
            <option key={option.value} value={option.value}>
              {option.label}
            </option>
          ))}
        </TextField> */}

         <br></br>
         
         <br></br>
         <Button variant="contained" color="secondary"  onClick={handleToUpdate}>
            edit task
         </Button>
        
        

         <Button  variant="contained" color="secondary"  onClick={handleToDelete}>
            
            delete task
         </Button>

        



    </Paper>



    </Container>
        );

}
export {ToDoElem}