

async function ServiceToUpdate(id, name, description,completed) {
    
    

    const task={name,description,completed}
    console.log(task)
    return fetch("http://localhost:8080/toDoList/updateTask?" + new URLSearchParams({
    toDoListId: id
    }),{
    method:"PUT",
    headers:{"Content-Type":"application/json"},
      body:JSON.stringify(task)
    }).then(()=>{
      
    console.log("task updated")
    })

    
}

export {ServiceToUpdate}