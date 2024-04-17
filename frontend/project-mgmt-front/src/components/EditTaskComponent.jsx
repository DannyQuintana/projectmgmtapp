import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getTaskByIdAPICall, updateTaskAPICall, deleteTaskAPICall } from "../services/TaskService";

const EditTaskComponent = () => {
  const { taskId } = useParams();
  const navigate = useNavigate();
  const [task, setTask] = useState({
    taskName: "",
    taskDescription: "",
    taskStatus: "",
    taskCommitDate: "",
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await getTaskByIdAPICall(taskId);
        setTask(response.data);
        console.log(response.data);
      } catch (error) {
        console.log("Error fetching data: ", error);
      }
    };

    if (taskId) {
      fetchData();
    }
  }, [taskId]);

  const handleUpdateTask = async (e) => {
    try {
      e.preventDefault();

      console.log(task);

      const response = await updateTaskAPICall(taskId, task);
      console.log(response.data);
      navigate(`/tasks/${task.projectId}`);
    } catch (error) {
      console.error("Error updating task: ", error);
    }
  };

  const handleDeleteTask = async () => {
    try {
      const id = task.projectId;
      const response = await deleteTaskAPICall(taskId);
      console.log(response.data);
      navigate(`/tasks/${id}`);
    } catch (error) {
      console.error("Error deleting task: ", error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setTask((prevTask) => ({
      ...prevTask,
      [name]: value,
    }));
  };

  return (
    <div className="container">
      <h2 className="text-center">Edit Task</h2>
      <form onSubmit={handleUpdateTask}>
        <div className="mb-3">
          <label htmlFor="taskName" className="form-label">
            Task Name
          </label>
          <input
            type="text"
            className="form-control"
            id="taskName"
            name="taskName"
            value={task.taskName}
            onChange={handleChange}
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
            name="taskDescription"
            value={task.taskDescription}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="taskStatus" className="form-label">
            Task Status
          </label>
          <select
            className="form-select"
            id="taskStatus"
            name="taskStatus"
            value={task.taskStatus}
            onChange={handleChange}
          >
            <option value="COMPLETE">Complete</option>
            <option value="IN_PROGRESS">In Progress</option>
            <option value="DELAYED">Delayed</option>
            <option value="HELP_REQUESTED">Help Requested</option>
          </select>
        </div>
        <div className="mb-3">
          <label htmlFor="taskCommitDate" className="form-label">
            Task Commit Date
          </label>
          <input
            type="date"
            className="form-control"
            id="taskCommitDate"
            name="taskCommitDate"
            value={task.taskCommitDate}
            onChange={handleChange}
          />
        </div>
        <button type="submit" className="btn btn-primary me-2">
          Update Task
        </button>
        <button type="button" className="btn btn-danger" onClick={handleDeleteTask}>
          Delete Task
        </button>
      </form>
    </div>
  );
};

export default EditTaskComponent;
