// App.js
import { Nav } from "react-bootstrap";
import "./App.css";
import Menubar from "./Component/Menubar";
import MainNav from "./Component/MainNav";

function App() {
  return (
    <div className="app-container">
      {/* 메뉴바 */}
      <Menubar />
      
      {/* 메인페이지 컨텐츠*/}
      <div className="main-content">
        <h1>My World's Today</h1>

     {/* 나브 */}
      <MainNav/>


      </div>


    </div>
  );
}

export default App;
