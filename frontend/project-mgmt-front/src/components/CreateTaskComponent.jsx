import React, { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { createTaskAPICall } from "../services/TaskService";

const CreateTaskComponent = () => {
  const navigate = useNavigate();
  const { projectId } = useParams();
  const [taskName, setTaskName] = useState("");
  const [taskDescription, setTaskDescription] = useState("");
  const [taskCommitDate, setTaskCommitDate] = useState("");
  const [error, setError] = useState("");
  const [successMessage, setSuccessMessage] = useState("");

  const handleNewTaskForm = async (e) => {
    e.preventDefault();

    // Form validation
    if (!taskName || !taskDescription || !taskCommitDate) {
      setError("Please fill out all fields.");
      return;
    }

    const currentDate = new Date();
    const selectedDate = new Date(taskCommitDate);

    if (selectedDate < currentDate) {
      setError("Commit date must be in the future.");
      return;
    }

    setError(""); // Clear any previous error message

    const taskData = {
      taskName,
      taskDescription,
      taskCommitDate,
      projectId: projectId,
    };

    try {
      const response = await createTaskAPICall(taskData);
      console.log(response.data);
      setSuccessMessage("Task created successfully!");
      setTimeout(() => {
        setSuccessMessage("");
        navigate(`/tasks/${projectId}`);
      }, 3000); // Clear the success message after 3 seconds
    } catch (error) {
      console.error("Error creating task: ", error);
    }
  };

  return (
    <div className="container">
      <h2 className="text-center">Create New Task</h2>
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <div className="card">
            <div className="card-body">
              {successMessage && (
                <div className="alert alert-success" role="alert">
                  {successMessage}
                </div>
              )}
              <form onSubmit={handleNewTaskForm}>
                <div className="mb-3">
                  <label htmlFor="taskName" className="form-label">
                    Task Name
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="taskName"
                    value={taskName}
                    onChange={(e) => setTaskName(e.target.value)}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="taskDescription" className="form-label">
                    Task Description
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="taskDescription"
                    value={taskDescription}
                    onChange={(e) => setTaskDescription(e.target.value)}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="taskCommitDate" className="form-label">
                    Task Commit Date
                  </label>
                  <input
                    type="date"
                    className="form-control"
                    id="taskCommitDate"
                    value={taskCommitDate}
                    onChange={(e) => setTaskCommitDate(e.target.value)}
                  />
                </div>
                {error && <p className="text-danger">{error}</p>}
                <button type="submit" className="btn btn-primary" disabled={!!successMessage}>
                  Create Task
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CreateTaskComponent;
