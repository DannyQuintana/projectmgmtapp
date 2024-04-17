import React, { useState, useEffect } from "react";
import { getUserByIdAPICall } from "../services/UserService";

const UserNameComponent = ({ teamMemberId }) => {
  const [userName, setUserName] = useState("");

  useEffect(() => {
    const fetchUserName = async () => {
      try {
        const user = await getUserByIdAPICall(teamMemberId);
        setUserName(`${user.firstName} ${user.lastName}`);
      } catch (error) {
        console.log("Error fetching user details: ", error);
      }
    };

    if (teamMemberId) {
      fetchUserName();
    }
  }, [teamMemberId]);

  return <>{userName || "Loading..."}</>;
};

export default UserNameComponent;
