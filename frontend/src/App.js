import React,{useEffect, useState} from 'react';

function App() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    fetch('/api/employees')
      .then(response => response.json())
      .then(data => setEmployees(data))
      .catch(error => console.error('Error fetching employees:', error));
  }, []);

  return(
    <div style={{ padding: '1rem' }}>
      <h1>Employees</h1>
      <table style={{ width: '100%', borderCollapse: 'collapse' }}>
        <thead>
          <tr>
            <th style={thStyle}>ID</th>
            <th style={thStyle}>First Name</th>
            <th style={thStyle}>Last Name</th>
            <th style={thStyle}>Email</th>
            <th style={thStyle}>Department</th>
            <th style={thStyle}>Salary</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(emp => (
            <tr key={emp.id}>
              <td style={tdStyle}>{emp.id}</td>
              <td style={tdStyle}>{emp.first_name}</td>
              <td style={tdStyle}>{emp.last_name}</td>
              <td style={tdStyle}>{emp.email}</td>
              <td style={tdStyle}>{emp.department}</td>
              <td style={tdStyle}>${emp.salary.toFixed(2)}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
 );
}
const thStyle = {
  border: '1px solid #ddd',
  padding: '8px',
  backgroundColor: '#f4f4f4',
  textAlign: 'left'
};

const tdStyle = {
  border: '1px solid #ddd',
  padding: '8px'
};
export default App;
