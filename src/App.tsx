import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './App.css';

import Home from './pages/Home'; 
import EventCalender from './pages/EventCalender'; 
import Blog from './pages/Blog';
import SportsCategories from './pages/SportsCategories';
import TeamProfile from './pages/TeamProfile';
import Results from './pages/Results';
import Resgistration from './pages/Registration';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Resgistration />} />
        <Route path="/EventCalender" element={<EventCalender />} />
        <Route path="/blogs" element={<Blog />} />
        <Route path="/athleteProfiles" element={<SportsCategories />} />
        <Route path="/teamProfiles" element={<TeamProfile />} />
        <Route path="/results" element={<Results />} />
        <Route path="/home" element={<Home />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

