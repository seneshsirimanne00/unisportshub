import React, { useEffect, useState } from 'react';
import Navbar from '../commonComponents/Navbar';
import axiosInstance from '../services/AxiosController';

export interface IResults {
  id: number; // Added id property
  eventId: number;
  sportId: number;
  teamAId: number;
  teamAScore: number;
  teamBId: number;
  teamBScore: number;
  achievements?: string[];
}

function Results() {

  const [results, setResults] = useState<IResults[]>([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axiosInstance.get('/results');
        const translatedData = response.data; 
        console.log("results",translatedData);
        const formattedResults = translatedData.map((result: { id: any; eventId: any; sportId: any; teamAId: any; teamAScore: any; teamBId: any; teamBScore: any; achievements: any; }) => ({
          id: result.id,
          eventId: result.eventId,
          sportId: result.sportId,
          teamAId: result.teamAId,
          teamAScore: result.teamAScore,
          teamBId: result.teamBId,
          teamBScore: result.teamBScore,
          achievements: result.achievements || [], 
        }));
        setResults(formattedResults);
      } catch (error) {
        console.error('Error fetching event data:', error);
      }
    };
  
    fetchData();
  }, []);

  return (
    <div className='app-container'>
        <Navbar />
        <div>
          <h1>Results Page</h1>
          <br/>
          <br/>
          <br/>
          <table>
            <tbody>
              <tr>
                <th>Event No</th>
                <th>Team A Score</th>
                <th>Team B Score</th>
              </tr>

              {results.map((result) => (
                <tr>
                  <td>{result.eventId}</td>
                  <td>{result.teamAScore}</td>
                  <td>{result.teamBScore}</td>
                </tr>
              ))}
            </tbody>
          </table>


        </div>

    </div>
  );
}

export default Results;
