import "./login.css"
function App() {
    
    return (
        <>
            <div className="main-container">
                <img className="login-image" src="../assets/A_2.png"></img>
                <div className="login-container">
                    <div className="title">LearnBlock login</div>
                    <div className="login-input">
                    <div className="input-name">Enter your email</div>
                    <input className="input-box"></input>
                </div>
                <div className="login-input">
                    <div className="input-name">Password</div>
                    <input className="input-box"></input>
                </div>
                </div>
            </div>

            <div className="signup">Sign up</div>

        </>

    )
}

export default App
