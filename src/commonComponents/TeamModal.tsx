import React, { useEffect, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import axiosInstance from '../services/AxiosController';

export interface ITeamModalData {
    id:number;
   }

   export interface IDetailedAthlete {
    id: number;
    name: string;
    userId: number;
    email: string;
    username: string;
    position: number; 
    achievements: string[];
  }
  

  const TeamModal: React.FC<ITeamModalData> = ({id}) => {

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const [athlete, setAthlete] = useState<IDetailedAthlete | null>(null);

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
        <>
        <Button variant="primary" onClick={handleShow}>
            view more
        </Button>

        <Modal size="xl" show={show} onHide={handleClose}>
        <Modal.Header closeButton style={{backgroundColor:"#1f1e1e"}} className="red-container">
            <Modal.Title></Modal.Title>
        </Modal.Header>
        <Modal.Body style={{backgroundColor:"#1f1e1e"}}>
        <section className="section about-section gray-bg" id="about">
          <div className="container">
              <div className="row align-items-center flex-row-reverse">
                  <div className="col-lg-6">
                      <div className="about-text go-to">
                          <h3 className="dark-color">name {athlete?.name}</h3>
                          <h6 className="theme-color lead">{athlete?.email}</h6>
                          <p>I <mark>design and develop</mark> services for customers of all sizes, specializing in creating stylish, modern websites, web services and online stores. My passion is to design digital user experiences through the bold interface and meaningful interactions.</p>
                          <div className="row about-list">
                              <div className="col-md-6">
                                  <div className="media">
                                      <label>Birthday</label>
                                      <p>4th april 1998</p>
                                  </div>
                                  <div className="media">
                                      <label>Age</label>
                                      <p>22 Yr</p>
                                  </div>
                                  <div className="media">
                                      <label>Residence</label>
                                      <p>Canada</p>
                                  </div>
                                  <div className="media">
                                      <label>Address</label>
                                      <p>California, USA</p>
                                  </div>
                              </div>
                              <div className="col-md-6">
                                  <div className="media">
                                      <label>E-mail</label>
                                      <p>info@domain.com</p>
                                  </div>
                                  <div className="media">
                                      <label>Phone</label>
                                      <p>820-885-3321</p>
                                  </div>
                                  <div className="media">
                                      <label>Skype</label>
                                      <p>skype.0404</p>
                                  </div>
                                  <div className="media">
                                      <label>Freelance</label>
                                      <p>Available</p>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
                  <div className="col-lg-6">
                      <div className="about-avatar">
                          {/* <img src="https://bootdey.com/img/Content/avatar/avatar7.png" title="" alt=""> */}
                      </div>
                  </div>
              </div>
              <div className="counter">
                  <div className="row">
                      <div className="col-6 col-lg-3">
                          <div className="count-data text-center">
                              <h6 className="count h2" data-to="500" data-speed="500">500</h6>
                              <p className="m-0px font-w-600">Happy Clients</p>
                          </div>
                      </div>
                      <div className="col-6 col-lg-3">
                          <div className="count-data text-center">
                              <h6 className="count h2" data-to="150" data-speed="150">150</h6>
                              <p className="m-0px font-w-600">Project Completed</p>
                          </div>
                      </div>
                      <div className="col-6 col-lg-3">
                          <div className="count-data text-center">
                              <h6 className="count h2" data-to="850" data-speed="850">850</h6>
                              <p className="m-0px font-w-600">Photo Capture</p>
                          </div>
                      </div>
                      <div className="col-6 col-lg-3">
                          <div className="count-data text-center">
                              <h6 className="count h2" data-to="190" data-speed="190">190</h6>
                              <p className="m-0px font-w-600">Telephonic Talk</p>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
        </section>
        </Modal.Body>
        <Modal.Footer style={{backgroundColor:"#1f1e1e"}} className="red-container">
            <Button variant="secondary" onClick={handleClose}>
            Close
            </Button>
        </Modal.Footer>
        </Modal>
    </>
  );
}

export default TeamModal;