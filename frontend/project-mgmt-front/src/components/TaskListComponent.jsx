import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { getAllTaskByProjectIdAPICall, getTasksAPICall } from "../services/TaskService";

const TaskListComponent = () => {
  const [tasks, setTasks] = useState([]);
  const { projectId } = useParams();
  console.log(projectId);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = projectId ? await getAllTaskByProjectIdAPICall(projectId) : await getTasksAPICall();
        setTasks(response.data);
      } catch (error) {
        console.log("Error fetching data: ", error);
      }
    };

    if (projectId) {
      fetchData();
    }
  }, [projectId]);

  return (
    <div className="container">
      <h2 className="text-center">Task List</h2>
      <div>
        <table className="table table-bordered table-striped">
          <thead>
            <tr>
              <th>Task Title</th>
              <th>Description</th>
            </tr>
          </thead>
          <tbody>
            {tasks.map((task) => (
              <tr key={task.id}>
                <td>{task.taskName}</td>
                <td>{task.taskDescription}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default TaskListComponent;
