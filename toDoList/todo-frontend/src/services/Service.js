

async function ServiceToDelete(id) {
    return fetch("http://localhost:8080/toDoList/deleteTask?" + new URLSearchParams({
    toDoListId: id
    }),{
    method:"DELETE",
    headers:{"Content-Type":"application/json"},
    }).then(()=>{
    console.log("task deleated")
    })
}

export {ServiceToDelete}
