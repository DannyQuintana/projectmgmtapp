import React from "react";

const StatusBarComponent = ({ data, dataType }) => {
  // Calculate the total count of each status type
  const statusCounts = data.reduce((acc, item) => {
    const status = dataType === "projects" ? item.projectProgress : item.taskStatus;
    acc[status] = (acc[status] || 0) + 1;
    return acc;
  }, {});

  // Calculate the percentage for each status type
  const totalCount = Object.values(statusCounts).reduce((total, count) => total + count, 0);
  const percentage = Object.keys(statusCounts).map((status) => ({
    status,
    percentage: ((statusCounts[status] || 0) / totalCount) * 100,
  }));

  return (
    <div className="status-bar">
      {percentage.map((status) => (
        <div key={status.status}>
          {status.status}: {status.percentage.toFixed(2)}%
        </div>
      ))}
    </div>
  );
};

export default StatusBarComponent;
