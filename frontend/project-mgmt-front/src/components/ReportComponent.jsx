import React, { useState, useEffect } from "react";
import SearchComponent from "./SearchComponent";
import { getAllProjects } from "../services/ProjectService";
import { getTasksAPICall } from "../services/TaskService";
import { getAllUsersAPICall } from "../services/UserService";
import StatusBarComponent from "./StatusBarComponent";

const ReportComponent = () => {
  const [dataType, setDataType] = useState("projects");
  const [data, setData] = useState([]);
  const [sortedData, setSortedData] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

  const fetchData = async () => {
    try {
      let response;
      if (dataType === "projects") {
        response = await getAllProjects();
      } else if (dataType === "tasks") {
        response = await getTasksAPICall();
      } else if (dataType === "users") {
        response = await getAllUsersAPICall();
      }
      setData(response.data);
    } catch (error) {
      console.log("Error fetching data: ", error);
    }
  };

  useEffect(() => {
    fetchData();
  }, [dataType]);

  useEffect(() => {
    let filteredData = data.filter((item) => {
      if (
        (dataType === "projects" &&
          item.projectTitle &&
          item.projectTitle.toLowerCase().includes(searchTerm.toLowerCase())) ||
        (dataType === "tasks" && item.taskName && item.taskName.toLowerCase().includes(searchTerm.toLowerCase())) ||
        (dataType === "users" &&
          item.firstName &&
          item.lastName &&
          (item.firstName.toLowerCase().includes(searchTerm.toLowerCase()) ||
            item.lastName.toLowerCase().includes(searchTerm.toLowerCase())))
      ) {
        return true;
      } else if (
        dataType === "projects" &&
        item.projectProgress &&
        item.projectProgress.toLowerCase().includes(searchTerm.toLowerCase()) // Include projectProgress field
      ) {
        return true;
      }
      return false;
    });
    setSortedData(filteredData);
  }, [data, searchTerm, dataType]);

  const handleSearch = (search) => {
    setSearchTerm(search);
  };

  return (
    <div className="container mt-5">
      <h2>Project and Task Status Report</h2>
      <div className="mb-3">
        <label htmlFor="dataType" className="form-label">
          Select Data Type:
        </label>
        <select id="dataType" className="form-select" value={dataType} onChange={(e) => setDataType(e.target.value)}>
          <option value="projects">Projects</option>
          <option value="tasks">Tasks</option>
          <option value="users">Users</option> {/* Added option for Users */}
        </select>
      </div>
      <div className="mb-3">
        <SearchComponent searchData={sortedData} onSearch={handleSearch} /> {/* Pass sortedData instead of data */}
      </div>
      <div className="mb-3">
        <StatusBarComponent data={sortedData} dataType={dataType} />
      </div>
      <table className="table">
        <thead>
          <tr>
            {dataType === "projects" && <th>Project Title</th>}
            {dataType === "tasks" && <th>Task Name</th>}
            <th>Description</th>
            <th>Status</th>
            <th>Due Date</th>
          </tr>
        </thead>
        <tbody>
          {sortedData.map((item) => (
            <tr key={item.id}>
              {dataType === "projects" && <td>{item.projectTitle || ""}</td>}
              {dataType === "tasks" && <td>{item.taskName || ""}</td>}
              <td>{item.projectDescription || item.taskDescription || ""}</td>
              <td>{item.projectProgress || item.taskStatus || ""}</td>
              <td>{item.projectCommitDate || item.taskCommitDate || ""}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ReportComponent;
