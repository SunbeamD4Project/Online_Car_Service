import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import Sidebar from "./MechanicSidebar";
import Loader from "../../../components/Loader";
import Pagination from "../../../components/Pagination"; 

const MechanicDashboard = () => {
  const darkMode = useSelector((state) => state.darkMode.isDarkMode);
  const [loading, setLoading] = useState(true);

  const [currentPage, setCurrentPage] = useState(1);
  const [jobsPerPage] = useState(3);

  const jobStats = [
    { title: "Total Jobs Assigned", value: 50 },
    { title: "Jobs Completed", value: 30 },
    { title: "Pending Jobs", value: 20 },
    { title: "Earnings", value: "$5,000" },
  ];

  const recentJobs = [
    ["John Doe", "Oil Change", "Completed"],
    ["Jane Smith", "Tire Rotation", "Pending"],
    ["Mike Johnson", "Brake Inspection", "In Progress"],
    ["Emily Davis", "Battery Replacement", "Completed"],
    ["Sarah Parker", "Air Filter Replacement", "In Progress"],
    ["George Clark", "Oil Change", "Pending"],
    ["Rachel Adams", "Tire Rotation", "Completed"],
    ["David Black", "Brake Inspection", "Completed"],
  ];

  const indexOfLastJob = currentPage * jobsPerPage;
  const indexOfFirstJob = indexOfLastJob - jobsPerPage;
  const currentJobs = recentJobs.slice(indexOfFirstJob, indexOfLastJob);

  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  useEffect(() => {
    const timer = setTimeout(() => setLoading(false), 1000);
    return () => clearTimeout(timer);
  }, []);

  return (
    <div className={`min-h-screen flex ${darkMode ? "bg-gray-900 text-gray-100" : "bg-gray-100 text-gray-800"}`}>
      <Sidebar />
      <main className="flex-1 p-6 space-y-8">
        <section className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-4">
          {jobStats.map((stat, index) => (
            <div
              key={index}
              className={`p-6 rounded-lg shadow-md flex flex-col items-center ${darkMode ? "bg-gray-800" : "bg-white"}`}
            >
              <h2 className={`text-lg font-semibold ${darkMode ? "text-yellow-400" : "text-blue-600"}`}>{stat.title}</h2>
              <p className="text-2xl font-bold mt-2">{stat.value}</p>
            </div>
          ))}
        </section>

        <section>
          <h2 className="text-2xl font-bold mb-4">Recent Jobs</h2>
          <table className={`w-full text-left border-collapse ${darkMode ? "text-gray-300" : "text-gray-800"}`}>
            <thead>
              <tr className={`${darkMode ? "bg-gray-700" : "bg-gray-200"} text-sm font-semibold`}>
                <th className="p-3">Customer Name</th>
                <th className="p-3">Service</th>
                <th className="p-3">Status</th>
              </tr>
            </thead>
            {loading ? (
              <div className="flex justify-center items-center h-40">
                <Loader />
              </div>
            ) : (
              <tbody>
                {currentJobs.map((job, index) => (
                  <tr
                    key={index}
                    className={`${darkMode ? (index % 2 === 0 ? "bg-gray-800" : "bg-gray-700") : (index % 2 === 0 ? "bg-white" : "bg-gray-100")}`}
                  >
                    {job.map((data, idx) => (
                      <td key={idx} className="p-3">{data}</td>
                    ))}
                  </tr>
                ))}
              </tbody>
            )}
          </table>

          <Pagination
            currentPage={currentPage}
            totalPages={Math.ceil(recentJobs.length / jobsPerPage)}
            onPageChange={paginate}
            siblingCount={1}
            pageRangeDisplayed={5}
          />
        </section>
      </main>
    </div>
  );
};

export default MechanicDashboard;
