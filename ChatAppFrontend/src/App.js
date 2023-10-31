import "./App.css";
import InputField from "./components/InputField/InputField";
import MessageContainer from "./components/MessageContainer/MessageContainer";
import socket from "./server";
import { useEffect, useState } from "react";

function App() {
  const [user,setUser] = useState(null)
  const [message , setMessage] = useState('')
  const [messageList , setMessageList] = useState([])
  const [rooms , setRooms] = useState([])

  useEffect(() => {
    socket.on('message' , (message) => {
      setMessageList((prevState) => prevState.concat(message))
      console.log("res", message);
    })
   
    socket.on("rooms",(res) => {
      setRooms(res)
    })

    askUserName()
  },[])

  const askUserName = () => {
    const userName = prompt("이름을 입력해주세요.");
    console.log("uuu", userName);
    
    socket.emit("login", userName, (res)=>{
          if(res?.ok){
            setUser(res.data) 
          }
    })
  };
  const sendMessage = (event) => {
   event.preventDefault()
   socket.emit("sendMessage" , message, (res) => {
    console.log("SendMessage", res);
   })
  }
  return (
    <div>
      <div className="App">
        <MessageContainer messageList={messageList} user={user} />
      <InputField message={message} setMessage={setMessage} sendMessage={sendMessage} />
      </div>
    </div>
  );
}

export default App;
