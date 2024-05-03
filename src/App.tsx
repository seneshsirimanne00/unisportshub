import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './App.css';

// Import your route components
import Home from './pages/Home'; // Assuming your home page component is in Home.tsx
import About from './pages/EventCalender'; // Assuming your about page component is in About.tsx
import News from './pages/News';
import SportsCategories from './pages/SportsCategories';
import TeamProfile from './pages/TeamProfile';
import Results from './pages/Results';
import Resgistration from './pages/Registration';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/EventCalender" element={<About />} />
        <Route path="/news" element={<News />} />
        <Route path="/sportsCategories" element={<SportsCategories />} />
        <Route path="/teamProfiles" element={<TeamProfile />} />
        <Route path="/results" element={<Results />} />
        <Route path="/resgistration" element={<Resgistration />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

