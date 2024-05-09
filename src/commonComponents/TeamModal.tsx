import React, { useEffect, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import axiosInstance from '../services/AxiosController';

export interface ITeamModalData {
    id:number;
   }

   export interface IDetailedTeam {
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

    const [Team, setTeam] = useState<IDetailedTeam | null>(null);
    useEffect(() => {
        const fetchTeam = async () => {
          try {
            const response = await axiosInstance.get(`http://localhost:8080/sport-club-manager-service/sports-club/${id}`); 
            const fetchedTeam = response.data as IDetailedTeam;
            setTeam(fetchedTeam);
          } catch (error) {
            console.error('Error fetching Team data:', error);
          }
        };
      
        fetchTeam();
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
                          <h3 className="dark-color">Team Profile</h3>
                          <br/>
                          <h6 className="theme-color lead">{Team?.username}</h6>
                          <div className="row about-list">
                              <div className="col-md-6">
                                  <div className="media">
                                      <label>Team Name</label>
                                      <p>{Team?.name}</p>
                                  </div>
                                  <div className="media">
                                      <label>winnings</label>
                                      <p>{Team?.position}</p>
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
                                      <p>{Team?.email}</p>
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

export default TeamModal;