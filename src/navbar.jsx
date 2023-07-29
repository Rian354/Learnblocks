import "./general.css"
import "./nav-bar.css"

export function Navbar() {
  return (
    <nav>
        <div className="nav__profile-container">
            <div className="nav__profile-container__profile-picture-container">
                <img className="nav__profile-container__profile-picture" src="https://i.redd.it/v0caqchbtn741.jpg"></img>
            </div>
            <div className="nav__profile-container__name-email-container">
                <div className="nav__profile-container__name">Joe Smith</div>
                <div className="nav__profile-container__email">example@gmail.com</div>
            </div>
        </div>
        <div className="nav__menu">
            <div className="nav__menu-button-active">
                <img className="nav__menu-button__icon" src="../assets/dashboard icon.svg"></img>
                <div className="nav__menu-button__title">Dashboard</div>
            </div>
            <div className="nav__menu-button">
                <img className="nav__menu-button__icon" src="../assets/classes icon.svg"></img>
                <div className="nav__menu-button__title">Upcoming Classes</div>
            </div>
            <div className="nav__menu-button">
                <img className="nav__menu-button__icon" src="../assets/grades icon.svg"></img>
                <div className="nav__menu-button__title">Grades</div>
            </div>
            <div className="nav__menu-button">
                <img className="nav__menu-button__icon" src="../assets/tutors icon.svg"></img>
                <div className="nav__menu-button__title">Tutors</div>
            </div>
            <div className="nav__menu-button">
                <img className="nav__menu-button__icon" src="../assets/notes icon.svg"></img>
                <div className="nav__menu-button__title">Notes</div>
            </div>
        </div>
        <div className="nav__bottom-menu">
            <div className="nav__menu-button">
                <img className="nav__menu-button__icon" src="../assets/settings icon.svg"></img>
                <div className="nav__menu-button__title">Settings</div>
            </div>
            <div className="nav__menu-button">
                <img className="nav__menu-button__icon" src="../assets/logout icon.svg"></img>
                <div className="nav__menu-button__title">Log out</div>
            </div>
        </div>
    </nav>
  )
}
