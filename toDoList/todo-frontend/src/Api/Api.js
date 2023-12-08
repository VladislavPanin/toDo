function GetToDo(){
    fetch("http://localhost:8080/toDoList/seeAllTasks")
        .then(res=>res.json())
        .then((result)=>{
            return result
        }
    )
}

export const API = {
    GetToDo: GetToDo
}