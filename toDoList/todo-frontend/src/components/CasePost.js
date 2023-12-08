import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';
import{ ServiceToDelete } from '../services/Service';
import { ServiceToUpdate } from '../services/ServiceToUpdate';
import { ToDoElem } from '../services/ToDoElem';
import ReactDOMServer from 'react-dom/server';


const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));

export default function CasePost() {
    const paperStyle={padding:'50px 20px', width:800,margin:"20px auto"}
    
    

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
    const[nameForAdd,setNameForAdd]=useState('')
    const[description,setDescription]=useState('')
    const[descriptionForAdd,setDescriptionForAdd]=useState('')
    const[completed,setCompleted]=useState('')
    const[completedForAdd,setCompletedForAdd]=useState('')
    const[tasks,setTasks]=useState([])



    
     const classes = useStyles();
     

    

  const handleClick=(e)=>{
    e.preventDefault()
    const task={name,description,completed}
    console.log(task)
    fetch("http://localhost:8080/toDoList/addTask",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(task)

  }).then(()=>{
    fetch("http://localhost:8080/toDoList/seeAllTasks")
    .then(res=>res.json())
    .then((result)=>{
    setTasks(result);
  })
    console.log("New task added")
  })
}


// const app = express();
//     app.get('/', (req, res) => {
//     const html = ReactDOMServer.renderToString(<MyComponent />);
//     res.send(`<div id="root">${html}</div>`);
//     });
//     app.listen(3000);


useEffect(()=>{
  fetch("http://localhost:8080/toDoList/seeAllTasks")
  .then(res=>res.json())
  .then((result)=>{
    setTasks(result);
  }
)
},[])
  return (

    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>Add Case</u></h1>

    <form className={classes.root} noValidate autoComplete="off">
    
      <TextField id="outlined-basic" label="case name" variant="outlined" fullWidth 
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="description" variant="outlined" fullWidth
      value={description}
      onChange={(e)=>setDescription(e.target.value)}
      />
       {/* <TextField id="outlined-basic" label="isCompleted" variant="outlined" fullWidth
      value={completed}
      onChange={(e)=>setCompleted(e.target.value)}
      /> */}
      <Button variant="contained" color="secondary" onClick={handleClick}>
        Submit
      </Button>
    </form>
   
    </Paper>
    
    


  
    
    
    
    
    
    <h1>My tasks</h1>

    <Paper elevation={3} style={paperStyle}>

      {tasks.map(task=>(
        
        // <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={task.toDoListId} >
         

        //  <TextField id="outlined-basic" label={task.name} variant="outlined" fullWidth 
        //   value={name}
        //   onChange={(e)=>setName(e.target.value)}
        //   />
        //   <br></br>
        //  <br></br>
        //   <TextField id="outlined-basic" label={task.description} variant="outlined" fullWidth
        //   value={description}
        //   onChange={(e)=>setDescription(e.target.value)}
        //   />
        //   <br></br>
        //  <br></br>
        //   <TextField id="outlined-basic" select
        //   label="Select"
        //   defaultValue="false" 
        //   variant="outlined" fullWidth
        //   value={completed}
        //   onChange={(e)=>setCompleted(e.target.value)}
        //   >
        // {currencies.map((option) => (
        //     <option key={option.value} value={option.value}>
        //       {option.label}
        //     </option>
        //   ))}
        // </TextField>

        //  <br></br>
         
        //  <br></br>
        //  <Button variant="contained" color="secondary"  onClick={(e)=>{ServiceToUpdate(task.toDoListId, name, description, completed)}}>
        //     edit task
        //  </Button>
        
        

        //  <Button  variant="contained" color="secondary"  onClick={(e)=>{ServiceToDelete(task.toDoListId)}}>
        //     delete task
        //  </Button>

        // </Paper>
        
        <ToDoElem task = {task} setTasks={setTasks} />
      ))
}
    

    </Paper>



    </Container>
    
  );
}