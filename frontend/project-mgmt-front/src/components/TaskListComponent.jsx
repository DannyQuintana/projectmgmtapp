import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { getAllTaskByProjectIdAPICall, getTasksAPICall, updateTaskAPICall } from "../services/TaskService";
import { Link } from "react-router-dom";

const TaskListComponent = () => {
  const [tasks, setTasks] = useState([]);
  const { projectId } = useParams();
  console.log(projectId);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = projectId ? await getAllTaskByProjectIdAPICall(projectId) : await getTasksAPICall();
        setTasks(response.data);
        console.log(response.data);
      } catch (error) {
        console.log("Error fetching data: ", error);
      }
    };

    if (projectId) {
      fetchData();
    }
  }, [projectId]);

  const getStatus = (status) => {
    switch (status) {
      case "COMPLETE":
        return "bg-success text-white";
      case "IN_PROGRESS":
        return "bg-info text-white";
      case "DELAYED":
        return "bg-danger text-white";
      case "HELP_REQUESTED":
        return "bg-warning text-dark";
      default:
        return "";
    }
  };

  const handleStatusChange = async (taskId, e) => {
    const newStatus = e.target.value;
    try {
      await updateTaskAPICall(taskId, { taskStatus: newStatus });
      const updatedTasks = tasks.map((task) => {
        if (task.id === taskId) {
          return { ...task, taskStatus: newStatus };
        }
        return task;
      });
      setTasks(updatedTasks);
    } catch (error) {
      console.log("Error updating task status: ", error);
    }
  };

  return (
    <div className="container">
      <h2 className="text-center">Task List</h2>

      <div>
        <table className="table table-bordered table-striped">
          <thead>
            <tr>
              <th>Task Title</th>
              <th>Description</th>
              <th>Owner</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {tasks.map((task) => (
              <tr key={task.id}>
                <td>{task.taskName}</td>
                <td>{task.taskDescription}</td>
                <td>Bob</td>
                <td className={getStatus(task.taskStatus)}>
                  <select
                    value={task.taskStatus}
                    onChange={(e) => handleStatusChange(task.id, e)}
                    style={{ border: "none", background: "none" }}
                  >
                    <option value="COMPLETE">Complete</option>
                    <option value="IN_PROGRESS">In Progress</option>
                    <option value="DELAYED">Delayed</option>
                    <option value="HELP_REQUESTED">Help Requested</option>
                  </select>
                </td>
                <td>
                  <Link to={`/edittask/${task.id}`} className="btn btn-primary">
                    Edit Task
                  </Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <Link to={`/createtask/${projectId}`} className=" col-md-4 mb-4 btn btn-primary">
        Add New task
      </Link>
    </div>
  );
};

export default TaskListComponent;
