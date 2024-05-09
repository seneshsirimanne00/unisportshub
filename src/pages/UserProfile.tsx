import React, { useContext, useEffect, useState } from 'react';
import Navbar from '../commonComponents/Navbar';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../AuthContext';
import axiosInstance from '../services/AxiosController';

export interface IDetailedAthlete {
  id: number;
  name: string;
  userId: number;
  email: string;
  username: string;
  position: number; 
  achievements: string[];
}

function UserProfile() {
  const navigate = useNavigate();
    const { isLoggedIn , userId , id } = useContext(AuthContext);

    const [athlete, setAthlete] = useState<IDetailedAthlete | null>(null);
  
    useEffect(() => {
      console.log('authcontext',isLoggedIn, userId, id);
      if (!isLoggedIn) {
        navigate('/');
      }
    }, [isLoggedIn, navigate]);

    useEffect(() => {
      const fetchAthlete = async () => {
        try {
          const response = await axiosInstance.get(`http://localhost:8080/sport-club-manager-service/athlete/${id}`); // Replace 4 with the actual ID
          const fetchedAthlete = response.data as IDetailedAthlete;
          setAthlete(fetchedAthlete);
        } catch (error) {
          console.error('Error fetching athlete data:', error);
        }
      };
    
      fetchAthlete();
    }, []);

  return (
    <div className='app-container'>
        <Navbar />
        <div>
          <h1>Welcome to the UserProfile Page! </h1>
            <p>{athlete?.name}</p>
            <p>{athlete?.email}</p>
            <p>{athlete?.position}</p>
            <p>{athlete?.username}</p>
            <p>{athlete?.achievements}</p>

        </div>

    </div>
  );
}

export default UserProfile;
