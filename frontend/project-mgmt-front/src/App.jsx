import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import { useState } from "react";
import "./App.css";
import HeaderComponent from "./components/HeaderComponent";
import RegisterComponent from "./components/RegisterComponent";
import FooterComponnent from "./components/FooterComponent";
import LoginComponent from "./components/LoginComponent";
import ProjectListComponent from "./components/ProjectListComponent";
import TaskListComponent from "./components/TaskListComponent";
import { CreateProjectComponet } from "./components/CreateProjectComponet";
import CreateTaskComponent from "./components/CreateTaskComponent";
import EditTaskComponent from "./components/EditTaskComponent";
import EditProjectComponent from "./components/EditProjectComponent";
import TeamListComponent from "./components/TeamListComponent";
import ReportComponent from "./components/ReportComponent";
import { isUserLoggedIn } from "./services/AuthService";

function App() {
  function AuthenticatedRoute({ children }) {
    const isAuth = isUserLoggedIn();

    if (isAuth) {
      return children;
    }

    return <Navigate to="/" />;
  }

  return (
    <BrowserRouter>
      <div style={{ paddingTop: "60px" }}>
        <HeaderComponent />
        <Routes>
          <Route path="/" element={<LoginComponent />} />
          <Route path="/login" element={<LoginComponent />} />

          <Route
            path="/projects"
            element={
              <AuthenticatedRoute>
                <ProjectListComponent />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/tasks/:projectId"
            element={
              <AuthenticatedRoute>
                <TaskListComponent />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/createproject"
            element={
              <AuthenticatedRoute>
                <CreateProjectComponet />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/createtask/:projectId"
            element={
              <AuthenticatedRoute>
                <CreateTaskComponent />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/edittask/:taskId"
            element={
              <AuthenticatedRoute>
                <EditTaskComponent />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/editproject/:projectId"
            element={
              <AuthenticatedRoute>
                <EditProjectComponent />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/teams"
            element={
              <AuthenticatedRoute>
                <TeamListComponent />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/reports"
            element={
              <AuthenticatedRoute>
                <ReportComponent />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/register"
            element={
              <AuthenticatedRoute>
                <RegisterComponent />
              </AuthenticatedRoute>
            }
          />
        </Routes>
        <FooterComponnent />
      </div>
    </BrowserRouter>
  );
}

export default App;
