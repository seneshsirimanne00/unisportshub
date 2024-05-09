import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './App.css';

import Home from './pages/Home'; 
import Blog from './pages/Blog';
import SportsCategories from './pages/SportsCategories';
import TeamProfile from './pages/TeamProfile';
import Results from './pages/Results';
import Resgistration from './pages/Registration';
import 'bootstrap/dist/css/bootstrap.min.css';
import { AuthContextProvider } from './AuthContext';
import { useState } from 'react';
import AdminPage from './pages/Admin';
import UserProfile from './pages/UserProfile';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false); 
  const [userId, setUserId] = useState<string | null>(null); 
  const [id, setId] = useState<string | null>(null);
  
  return (
    <AuthContextProvider value={{ isLoggedIn, userId, id, setIsLoggedIn, setUserId , setId }}>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Resgistration />} />
        <Route path="/profile" element={<UserProfile />} />
        <Route path="/blogs" element={<Blog />} />
        <Route path="/athleteProfiles" element={<SportsCategories />} />
        <Route path="/teamProfiles" element={<TeamProfile />} />
        <Route path="/results" element={<Results />} />
        <Route path="/home" element={<Home />} />
        <Route path="/admin" element={<AdminPage />} />
      </Routes>
    </BrowserRouter>
    </AuthContextProvider>
  );
}

export default App;

