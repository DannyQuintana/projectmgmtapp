import React, { useState } from "react";

const SearchComponent = ({ searchData, onSearch }) => {
  const [searchTerm, setSearchTerm] = useState("");

  const handleSearch = (event) => {
    const searchTerm = event.target.value;
    setSearchTerm(searchTerm);
    onSearch(searchTerm);
  };

  return (
    <input
      type="text"
      className="form-control" // corrected typo here
      placeholder="Search"
      value={searchTerm}
      onChange={handleSearch}
    />
  );
};

export default SearchComponent;
