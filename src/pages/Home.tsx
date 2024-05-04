import React, { useState } from 'react';
import Navbar from '../commonComponents/Navbar';
import { Swiper, SwiperSlide } from 'swiper/react';

import image133 from '../assets/image 133.png';
import image134 from '../assets/image 134.png';
import image135 from '../assets/image 135.png';
// Import Swiper styles
import 'swiper/css';
import 'swiper/css/pagination';
import 'swiper/css/navigation';

import { Autoplay, Pagination, Navigation } from 'swiper/modules';
import EventCard from '../commonComponents/EventCard';
import {IEventCardData} from '../commonComponents/EventCard';
import RPerformanceCard from '../commonComponents/RecentPerformanceCard';
import {IRPerformanceCardData} from '../commonComponents/RecentPerformanceCard';
import TeamCard, { ITeamCardData } from '../commonComponents/TeamCard';

function Home() {

  // event card data
  const [eventData, setEventData] = useState<IEventCardData[]>([
    {
      title: 'Event 1 Title',
      description: 'This is a description for event 1.',
      date: '2024-10-26',
    },
    {
      title: 'Event 2 Title',
      description: 'This is a description for event 2.',
      date: '2024-10-27',
    },
    {
      title: 'Event 3 Title',
      description: 'This is a description for event 3.',
      date: '2024-10-28',
    },
  ]);

  // event card data
  const [rPerformanceCardData, setRperformanceCard] = useState<IRPerformanceCardData[]>([
    {
      title: '1 Title',
      description: 'This is a description for event 1.',
    },
    {
      title: '2 Title',
      description: 'This is a description for event 2.',
    },
    {
      title: '3 Title',
      description: 'This is a description for event 3.',
    },
  ]);

  const [teamCard, setTeamCard] = useState<ITeamCardData[]>([
    {
      name: 'Team 1 Name',
      username: 'team1username',
      winnings: 10,
      loses: 5,
      players: 5,
    },
    {
      name: 'Team 2 Name',
      username: 'team2username',
      winnings: 8,
      loses: 7,
      players: 6,
    },
    {
      name: 'Team 3 Name',
      username: 'team3username',
      winnings: 12,
      loses: 2,
      players: 7,
    },
  ]);
  
  return (
    <div className='app-container'>
      <Navbar />
        
    <div className="row red-container" style={{ width: "100%", height: "20vh" }} />

    <Swiper
        spaceBetween={30}
        centeredSlides={true}
        autoplay={{
          delay: 2500,
          disableOnInteraction: false,
        }}
        pagination={{
          clickable: true,
        }}
        navigation={true}
        modules={[Autoplay, Pagination, Navigation]}
        className="mySwiper"
      >
        <SwiperSlide  style={{ backgroundImage: `url(${image133})`}}></SwiperSlide>
        <SwiperSlide  style={{ backgroundImage: `url(${image134})`}}></SwiperSlide>
        <SwiperSlide  style={{ backgroundImage: `url(${image135})`}}></SwiperSlide>

      </Swiper>

      <div className="container" style={{ padding: "40px 0", backgroundColor: "#282828" }}>
        <div className="row">
          <div className="col-lg-8 col-md-6 col-sm-12">
            <h1>Tournaments & Events</h1>

            <button className="button2">View all events</button>
            <br/>
            {eventData.map((cardData) => (
              <EventCard key={cardData.title} title={cardData.title} description={cardData.description} date={cardData.date} />
            ))}
          </div>

          <div className="col-lg-4 col-md-6 col-sm-12">
            <h3>Recent Perfomance </h3>

            {rPerformanceCardData.map((cardData) => (
              <RPerformanceCard key={cardData.title} title={cardData.title} description={cardData.description} />
            ))}
          </div>
          
        </div>
      </div>

      <br/>

       <div className="accordion accordion-flush" id="accordionFlushExample" style={{color: "#000 !important"}}>
        <div className="accordion-item">
          <h2 className="accordion-header" id="flush-headingOne">
            <button className="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
              <h1>Sports Categories 
                <svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" className="bi bi-arrow-down-circle-fill" viewBox="0 0 16 16">
                    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293z"/>
                  </svg>

              </h1>
            </button>
          </h2>
          <div id="flush-collapseOne" className="accordion-collapse collapse" aria-labelledby="flush-headingOne" style={{color: "#000 !important"}} data-bs-parent="#accordionFlushExample">
            <div className="accordion-body" style={{maxHeight: "50vh" , overflowX: "auto"}}>
            
            
                <div className="container " id="featured-3">
                   
                    <div className="row g-4 py-5 row-cols-1 row-cols-lg-3" style={{color: "#000 !important"}}>
                      <div className="feature col">
                        <div className="feature-icon ">
                            <img src="cricket.gif" style={{width: "50px"}}/>    </div>
                        <h2>Cricket</h2>
                        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
                        <a href="#" className="icon-link button2">
                          Call to action
                          <svg className="bi" width="1em" height="1em"></svg>
                        </a>
                      </div>
                      <div className="feature col">
                        <div className="feature-icon ">
                            <img src="tennis.gif" style={{width: "50px"}}/>        </div>
                        <h2>Tennis</h2>
                        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
                        <a href="#" className="icon-link button2">
                          Call to action
                          <svg className="bi" width="1em" height="1em"></svg>
                        </a>
                      </div>
                      <div className="feature col">
                        <div className="feature-icon ">
                            <img src="football-player.gif" style={{width: "50px"}}/>      </div>
                        <h2>Football</h2>
                        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
                        <a href="#" className="icon-link button2">
                          Call to action
                          <svg className="bi" width="1em" height="1em"></svg>
                        </a>
                      </div>

                      <div className="feature col">
                        <div className="feature-icon ">
                            <img src="badminton.gif" style={{width: "50px"}}/>      </div>
                        <h2>Badminton</h2>
                        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
                        <a href="#" className="icon-link button2">
                          Call to action
                          <svg className="bi" width="1em" height="1em"></svg>
                        </a>
                      </div>
                      <div className="feature col">
                        <div className="feature-icon ">
                            <img src="swimmer.gif" style={{width: "50px"}}/>      </div>
                        <h2>Swimmer</h2>
                        <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
                        <a href="#" className="icon-link button2" >
                          Call to action
                          <svg className="bi" width="1em" height="1em"></svg>
                        </a>
                      </div>
                    </div>
                  </div>
            
            </div>
          </div>
        </div>
   
      </div>

      <br/>
      <h1>Top perfomance</h1>
      <br/>


      <h4>Top Teams <button className="button2">Browse Teams</button></h4>
      <br/>

      <div className="row" style={{maxHeight: "350px" , overflowX: "auto"}}>

        <div className="col">
        <a href="profile-team.html" style={{textDecoration: "none"}}>
        {teamCard.map((cardData) => (
              <TeamCard key={cardData.name} name={cardData.name} username={cardData.username} winnings={cardData.winnings} loses={cardData.loses} players={cardData.players} />
            ))}
        </a>
            
        </div>
      </div>
      
      <hr/>
        <br/>
        <h4>Top Athletes <button className="button2">Browse Athletes</button></h4>
        <br></br>
      
        <div className="row" style={{maxHeight: "350px;" , overflowX: "auto"}}>

          <div className="col">

            <div className="team-card">
              <div className="team-card-info">
              <div className="team-card-avatar"></div>
              <div className="team-card-title">Steve Jobs</div>
              <div className="team-card-subtitle">CEO &amp; Co-Founder</div>
              </div>
              <ul className="team-card-social">
              <li className="team-card-social__item">
            wins = <b>2</b></li>
            <li className="team-card-social__item">
            Losses = <b>5</b></li>
            <li className="team-card-social__item">
            Played = <b>8</b>
            </li>
            </ul>
            </div>  

          </div>
        </div>


        <div className="row red-container" style={{width: "100%", height: "20vh"}}>

</div>

<div className="container" style={{paddingBottom: "30px"}}>
    <div className="row" style={{textAlign: "center", paddingTop: "20px" , paddingBottom: "40px"}}>
        <br/>
        <h1> News and Updates</h1>
        <h3>Check Latest info about the events and perfomances.</h3>
        <button className="button2" style={{width: "30%", margin: "auto"}}>View all News</button>
    </div>

    <div className="row">
    <div className="col-lg-8 col-md-8 col-sm-12">
      <div className="row">

        <div className="col-4">
            
            <div className="blog-card">
                <div className="blog-image"></div>
                 <div className="blog-content">
                   <a href="#">
                     <span className="blog-title">
                       Lorem ipsum dolor sit amet consectetur adipisicing elit.
                     </span>
                   </a>
               
                   <p className="blog-desc">
                     Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae
                     dolores, possimus pariatur animi temporibus nesciunt praesentium 
                   </p>
               
                   <a className="blog-action" href="blog.html">
                     Find out more
                     <span aria-hidden="true">
                       →
                     </span>
                   </a>
                 </div>
               </div>
        </div>

    </div>
    </div>

    <div className="col-lg-4 col-md-4 col-sm-12">

        <h2>Updates today</h2>

        <div style={{width: "100%" , maxHeight: "40vh", overflowX: "auto"}}>

        <div className="update-card">
            <div className="update-img"></div>
            <div className="update-textBox">
              <div className="update-textContent">
                <p className="update-h1">Clans of Clash</p>
                <span className="update-span">12 min ago</span>
              </div>
              <p className="update-p">Xhattmahs is not attacking your base!</p>
            <div>
          </div></div></div>

        </div>
    </div>
</div>
</div>

<div className="row red-container" style={{width: "100%", height: "20vh"}}>

</div>

<div className="container">
    <div className="row">
        <div className="col-lg-4">
<h1 style={{fontWeight: "lighter"}}>Year <b style={{fontSize: "4rem", fontWeight: "900"}}>Event</b> Calender</h1>
     <p> Check out the events and other sports days happening!!! <button className="button2">Calander Days</button></p>


        </div>
        <div className="col-lg-8">

            <div className="container" style={{maxHeight: "60vh", overflowX: "auto"}}>
                <div className="row row-striped">
                    <div className="col-2 text-right">
                        <h1 className="display-4"><span className="badge badge-secondary">16</span></h1>
                        <h2>OCT</h2>
                    </div>
                    <div className="col-10">
                        <h3 className="text-uppercase"><strong>Ice Cream Social</strong></h3>
                        <ul className="list-inline">
                            <li className="list-inline-item"><i className="fa fa-calendar-o" aria-hidden="true"></i> Monday</li>
                            <li className="list-inline-item"><i className="fa fa-clock-o" aria-hidden="true"></i> 12:30 PM - 2:00 PM</li>
                            <li className="list-inline-item"><i className="fa fa-location-arrow" aria-hidden="true"></i> Cafe</li>
                        </ul>
                        <p>Lorem ipsum dolsit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                 
                    </div>
                
                </div>
            </div>
            
        </div>
    </div>
</div>


<div className="row red-container" style={{width: "100%", height: "20vh"}}>

</div>
<button className="Btn">
  
    <div className="sign"><svg viewBox="0 0 512 512"><path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></path></svg></div>
    
    <div className="text">Logout</div>
  </button>
  
  
  

<button className="noti-button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
    <svg className="noti-bell" viewBox="0 0 448 512"><path d="M224 0c-17.7 0-32 14.3-32 32V49.9C119.5 61.4 64 124.2 64 200v33.4c0 45.4-15.5 89.5-43.8 124.9L5.3 377c-5.8 7.2-6.9 17.1-2.9 25.4S14.8 416 24 416H424c9.2 0 17.6-5.3 21.6-13.6s2.9-18.2-2.9-25.4l-14.9-18.6C399.5 322.9 384 278.8 384 233.4V200c0-75.8-55.5-138.6-128-150.1V32c0-17.7-14.3-32-32-32zm0 96h8c57.4 0 104 46.6 104 104v33.4c0 47.9 13.9 94.6 39.7 134.6H72.3C98.1 328 112 281.3 112 233.4V200c0-57.4 46.6-104 104-104h8zm64 352H224 160c0 17 6.7 33.3 18.7 45.3s28.3 18.7 45.3 18.7s33.3-6.7 45.3-18.7s18.7-28.3 18.7-45.3z"></path></svg>
  
   <div className="noti-arrow">›</div>
 </button>
 



<div className="offcanvas offcanvas-start"  id="offcanvasExample" aria-labelledby="offcanvasExampleLabel" style={{color: "#000"}}>
    <div className="offcanvas-header">
      <h5 className="offcanvas-title" id="offcanvasExampleLabel">Offcanvas</h5>
      <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div className="offcanvas-body">
      <div>
        Some text as placeholder. In real life you can have the elements you have chosen. Like, text, images, lists, etc.
      </div>
      <div className="dropdown mt-3">
        <button className="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown">
          Dropdown button
        </button>
        <ul className="dropdown-menu">
          <li><a className="dropdown-item" href="#">Action</a></li>
          <li><a className="dropdown-item" href="#">Another action</a></li>
          <li><a className="dropdown-item" href="#">Something else here</a></li>
        </ul>
      </div>
    </div>
  </div>



      {/* div for the container */}

    </div>
  );
}

export default Home;
