import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";
import "./App.css";
import HeaderComponent from "./components/HeaderComponent";
import RegisterComponent from "./components/RegisterComponent";
import FooterComponnent from "./components/FooterComponent";
import LoginComponent from "./components/LoginComponent";
import ProjectListComponent from "./components/ProjectListComponent";
import BodyComponent from "./components/BodyComponent";
import TaskListComponent from "./components/TaskListComponent";

function App() {
  const [count, setCount] = useState(0);

  return (
    <BrowserRouter>
      <div style={{ paddingTop: "60px" }}>
        <HeaderComponent />
        <Routes>
          <Route path="/" element={<BodyComponent />}></Route>
          <Route path="/projects" element={<ProjectListComponent />}></Route>
          <Route path="/tasks/:projectId" element={<TaskListComponent />} />
          <Route path="/register" element={<RegisterComponent />}></Route>
          <Route path="/login" element={<LoginComponent />}></Route>
        </Routes>
        <FooterComponnent />
      </div>
    </BrowserRouter>
  );
}

export default App;
