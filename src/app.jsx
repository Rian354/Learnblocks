import { useState, useEffect } from 'react'
import $ from 'jquery';
import "./general.css"
import {Navbar} from "./navbar.jsx";

import "./header-cards-schedule.css"

function App() {
  const [courses,setCourses] = useState([])

  useEffect(() => {
    setCourses([
      {
        img:"https://www.shutterstock.com/image-photo/pile-books-on-table-learning-260nw-1016636398.jpg",
        title:"English Course",
        tagline:"Master the English language",
        description:"Starts today at 1 1 AM, Room 300"
      },
      {
        img:"https://t4.ftcdn.net/jpg/04/68/33/03/360_F_468330396_NocCJyI0P1NkXMK4uhixUoD9rzMQNdFk.jpg",
        title:"Human Biology",
        tagline:"Discover the wonders of the...",
        description:"Wednesday 10/5, 2 PM, Room 766"
      },
      {
        img:"https://picjumbo.com/wp-content/uploads/checking-stock-market-data-on-smartphone-2210x1473.jpg",
        title:"Verified Credit",
        tagline:"Leading Markets",
        description:"Monday 15/5, 11 AM"
      },
      {
        img:"https://thumbs.dreamstime.com/b/young-students-classmates-help-friend-catching-up-workbook-learning-tutoring-library-education-school-concept-138294323.jpg",
        title:"Paper Review",
        tagline:"Review with your tutor",
        description:"Friday 19/5, 9 AM Online Tutoring Session"
      },
    ])
  },[])

  return (
    <>
        <Navbar/>

        <header>   
            Discover
            <div className="header__icons">
                <input className="header__searchbar" placeholder='Search for Tutors'></input>
                <img className="nav__menu-button__icon" src="../assets/bell-icon-silhouette-svgrepo-com (1).svg"></img>
                <img className="nav__menu-button__icon" src="../assets/message-square-search-svgrepo-com.svg"></img>
                <img className="nav__menu-button__icon" src="../assets/envelope-svgrepo-com.svg"></img>
            </div>
        </header>

        <div className="cards">
          {courses.map(card => { return (
              <div className="card" key={card.title}>
                <img className="card__img" src={card.img}></img>
                <div className="card-left-container">
                  <div className="card__title">{card.title}</div>
                  <div className="card__tagline">{card.tagline}</div>
                  <div className="card__description">{card.description}</div>
                </div>
              </div>
            )
          })}
        </div>
        

        <div className="schedule-container">
          <div className="schedule-title-container">
            <div className="schedule-title-box">
              <div className="schedule-title-box__title">Your Schedule</div>
            </div>

            <div className="schedule-dates-box">
              <div className="schedule-dates__icon"></div>
              <div className="schedule-dates__text">May 01 - May 21,2023</div>
              <div className="schedule-dates__toggles"></div>
            </div>
          </div>
        </div>
    </>
  )
}

export default App
