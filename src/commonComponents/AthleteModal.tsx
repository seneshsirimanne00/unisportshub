import React, { useEffect, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import axiosInstance from '../services/AxiosController';

export interface IAthleteModalData {
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
  

  const AthleteModal: React.FC<IAthleteModalData> = ({id}) => {

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
                  <div className="col-lg-12">
                      <div className="about-text go-to">
                          <h3 className="dark-color">Athlete Profile</h3>
                          <h6 className="theme-color lead">{athlete?.username}</h6>
                          <br/>
                          <div className="row about-list">
                              <div className="col-md-6">
                                  <div className="media">
                                      <label>athlete Name</label>
                                      <p>{athlete?.name}</p>
                                  </div>
                                  <div className="media">
                                      <label>position</label>
                                      <p>{athlete?.position}</p>
                                  </div>
                                  {/* <div className="media">
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
                                  </div> */}
                              </div>
                              <div className="col-md-6">
                                  <div className="media">
                                      <label>E-mail</label>
                                      <p>{athlete?.email}</p>
                                  </div>
                                  {/* <div className="media">
                                      <label>Phone</label>
                                      <p>820-885-3321</p>
                                  </div>
                                  <div className="media">
                                      <label>Skype</label>
                                      <p>skype.0404</p>
                                  </div> */}
                              </div>
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

export default AthleteModal;