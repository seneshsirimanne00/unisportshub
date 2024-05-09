import React, { useContext, useEffect, useState } from 'react';
import Navbar from '../commonComponents/Navbar';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../AuthContext';

enum UserType {
    Team = 2,
    Council = 3,
    Athlete = 5,
  }

function AdminPage() {

    const navigate = useNavigate();
    const { isLoggedIn , userId, id } = useContext(AuthContext);
  
    useEffect(() => {
      console.log('authcontext',isLoggedIn, userId );
      if (!isLoggedIn) {
        navigate('/');
      }
    }, [isLoggedIn, navigate]);

    // team states

    const [eventId, setEventId] = useState(8); // Pre-filled event ID (adjust as needed)
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [eligibilityDetails, setEligibilityDetails] = useState([]);
    const [participationGuidelines, setParticipationGuidelines] = useState([]);
    const [registrationProcedure, setRegistrationProcedure] = useState([]);
    const [eventDate, setEventDate] = useState('2024-05-10T00:00:00'); // Adjust for current date
    const [teamA, setTeamA] = useState(1);
    const [teamB, setTeamB] = useState(2);
    const [sportId, setSportId] = useState(1);
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {
        // api for 
        if (id === UserType.Team){
            
        }
  
        if (id === UserType.Council){
  
        }
      }, []);

      const handleSubmit = async (e: { preventDefault: () => void; }) => {
        e.preventDefault(); // Prevent default form submission behavior

      };
      
  return (
    <div className='app-container'>
        <Navbar />
        <div>
          <h6>logged in as a {userId === UserType.Team  &&  "team" } { userId === UserType.Council  &&  "Council" } </h6>

          {userId === UserType.Team && 
          <>
          <p>create an event</p>

          <form onSubmit={handleSubmit}>

           
          </form>

          </>
          }

          {userId === UserType.Council && 
          <>
          <p>create a Team</p>
          </>
          }
        

        </div>

    </div>
  );
}

export default AdminPage;