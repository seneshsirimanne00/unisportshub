import React, { useContext, useEffect, useState } from 'react';
import Navbar from '../commonComponents/Navbar';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../AuthContext';
import axiosInstance from '../services/AxiosController';

enum UserType {
    Team = 2,
    Council = 3,
    Athlete = 5,
  }

  
interface Team {
  username: string;
  password: string;
  name: string;
  email: string;
  userId: number;
  achievements: string[];
  logoBase64?: string; 
  basicInfo: string;
  winnings: number;
  losses: number;
}

interface Event {
  eventId?: number; 
  name: string;
  description: string;
  eligibilityDetails: string[];
  participationGuidelines: string[];
  registrationProcedure: string[];
  eventDate: string;
  teamA: number;
  teamB: number;
  sportId: number;
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

    // team states -> create by council (super admin)

    const [team, setTeam] = useState<Team>({
      username: '',
      password: '',
      name: '',
      email: '',
      userId: 2, 
      achievements: ["achievements here"],
      logoBase64: '', 
      basicInfo: '',
      winnings: 0, 
      losses: 0,
    });
    const [teamSuccess, setTeamSuccess] = useState(false);
    const [teamError, setTeamError] = useState(false);


    const handleChangeTeam = (event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
      const { name, value } = event.target;
        setTeam({ ...team, [name]: Number.isNaN(parseInt(value)) ? value : parseInt(value) });

    };


    const handleSubmitTeam = async (event: React.FormEvent<HTMLFormElement>) => {
      event.preventDefault();
  
      try {
        console.log('Team create:', team);
        const response = await axiosInstance.post('/sports-club', team, {
          headers: {
            'userId': 3, 
          },
        });
        if (response.data) {setTeamSuccess(true);}

      } catch (error) {
        console.error('Error creating team:', error);
        setTeamError(true);
        setTeamSuccess(false);
      }
    };

    // event states -> create by team admin and super admin

    const [nevent, setNevent] = useState<Event>({
      eventId: 8,
      name: '',
      description: '',
      eligibilityDetails: [],
      participationGuidelines: [],
      registrationProcedure: [],
      eventDate: '',
      teamA: 0, 
      teamB: 0,
      sportId: 0,
    });

    const [eventSuccess, setEventSuccess] = useState(false);
    const [eventError, setEventError] = useState(false);

    const handleChange = (event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
      const { name, value } = event.target;
      setNevent({ ...nevent, [name]: Number.isNaN(parseInt(value)) ? value : parseInt(value) });
    };
  
    const handleDateChange = (event: React.ChangeEvent<HTMLInputElement>) => {
      setNevent({ ...nevent, eventDate: event.target.value });
    };
  
    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
      event.preventDefault();
  
      try {
        //const formattedDate = new Date(event.target.eventDate.value).toISOString(); // Ensure proper date format
        console.log('create event',nevent);
        const response = await axiosInstance.post('/event', nevent, {
          headers: {
            'userId': 3, 
          },
        });
        if (response.data) {setEventSuccess(true);}
      } catch (error) {
        console.error('Error creating event:', error);
        setEventError(true);
        setEventSuccess(false);
      }
    };
  

      
  return (
    <div className='app-container'>
        <Navbar />
        <div>
          <br/>
          <h6 style={{ paddingInline: '5%'}}>logged in as super admin </h6>

          <br/><br/>
          <form onSubmit={handleSubmit} style={{ display: 'flex', padding: '5%', alignItems: 'stretch', flexDirection: 'column' }}>
          <h5>create an event</h5>
          <br/>
            
            <label htmlFor="name">Event Name:</label>
            <input type="text" id="name" name="name" value={nevent.name} onChange={handleChange} required />

            <label htmlFor="description">Description:</label>
            <textarea id="description" name="description" value={nevent.description} onChange={handleChange} required />

            {/* <label htmlFor="eligibilityDetails">Eligibility Details (separate each point by comma):</label>
            <textarea id="eligibilityDetails" name="eligibilityDetails" value={nevent.eligibilityDetails.join(', ')} onChange={handleChange} />

            <label htmlFor="participationGuidelines">Participation Guidelines (separate each point by comma):</label>
            <textarea id="participationGuidelines" name="participationGuidelines" value={nevent.participationGuidelines.join(', ')} onChange={handleChange} />

            <label htmlFor="registrationProcedure">Registration Procedure (separate each step by comma):</label>
            <textarea id="registrationProcedure" name="registrationProcedure" value={nevent.registrationProcedure.join(', ')} onChange={handleChange} /> */}

            <label htmlFor="eventDate">Event Date:</label>
            <input type="datetime-local" id="eventDate" name="eventDate" value={nevent.eventDate} onChange={handleDateChange} required />

            <label htmlFor="teamA">Team A ID:</label>
            <input type="number" id="teamA" name="teamA" value={nevent.teamA} onChange={handleChange} required />

            <label htmlFor="teamB">Team B ID:</label>
            <input type="number" id="teamB" name="teamB" value={nevent.teamB} onChange={handleChange} required />

            <label htmlFor="sportId">Sport ID:</label>
            <input type="number" id="sportId" name="sportId" value={nevent.sportId} onChange={handleChange} required />

            <button type="submit">Create</button>
            {eventSuccess && <h6 style={{color:'green'}}>Event created successfully!</h6>}
            {eventError && <h6 style={{color:'red'}}>An error occured ! refresh page and try again.</h6>}
          </form>

          {/* <form onSubmit={handleSubmit}>

           
          </form> */}


          <br/><br/>
          <form onSubmit={handleSubmitTeam} style={{ display: 'flex', padding: '5%', alignItems: 'stretch', flexDirection: 'column' }}>
            <h5>create a Team</h5>
            <br/>
            <label htmlFor="username">Username:</label>
            <input type="text" id="username" name="username" value={team.username} onChange={handleChangeTeam} required />

            <label htmlFor="password">Password:</label>
            <input type="password" id="password" name="password" value={team.password} onChange={handleChangeTeam} required />

            <label htmlFor="name">Team Name:</label>
            <input type="text" id="name" name="name" value={team.name} onChange={handleChangeTeam} required />

            <label htmlFor="email">Email:</label>
            <input type="email" id="email" name="email" value={team.email} onChange={handleChangeTeam} required />

            {/* <label htmlFor="achievements">Achievements (comma separated):</label>
            <textarea id="achievements" name="achievements" value={team.achievements.join(', ')} onChange={handleChangeTeam} /> */}

            {/* <label htmlFor="logo">Logo (optional):</label>
            <input type="file" id="logo" name="logo" accept="image/*" onChange={handleLogoChangeTeam} /> */}

            <label htmlFor="basicInfo">Basic Info:</label>
            <textarea id="basicInfo" name="basicInfo" value={team.basicInfo} onChange={handleChangeTeam} />

            <label htmlFor="winnings">Winnings:</label>
            <input type="number" id="winnings" name="winnings" value={team.winnings} onChange={handleChangeTeam} />

            <label htmlFor="losses">Losses:</label>
            <input type="number" id="losses" name="losses" value={team.losses} onChange={handleChangeTeam} />

            <button type="submit">Create Team</button>
            {teamSuccess && <h6 style={{color:'green'}}>Team created successfully!</h6>}
            {teamError && <h6 style={{color:'red'}}>An error occured ! refresh page and try again.</h6>}
          </form>
        

        </div>

    </div>
  );
}

export default AdminPage;