import React from 'react';
import { Card, Button } from "antd"
import { CarOutlined } from "@ant-design/icons"
import styled from "@xstyled/styled-components";

//import { useHistory } from "react-router-dom";
import './Home.css'
import "antd/dist/antd.css";

class Home extends React.Component {

    routeChangeSignUp = () => {
        this.props.history.push('/signup');
        //return <Redirect to="/signup/" />

    }

    routeChangeLogIn = () => {
        this.props.history.push('/login');
        //return <Redirect to="/login/" />

    }

    render() {
        return (
            <div className="hero" style={{ marginTop: 100, height: 300}}>
                <Card title={<StyledTitle level={2}><CarOutlined /> Easy Park</StyledTitle>} bordered={false}
                    style={{
                        width: 791, height: 528, backgroundColor: '#14a7ac', border: 0,
                        opacity: '0.82', borderRadius: '30px', margin: "auto"

                    }}
                    headStyle={{ border: 0 }}
                    bodyStyle={{ border: 0 }}
                >
                    <StyledDiv>
                        <StyledP> <StyledButton onClick={this.routeChangeSignUp}>Sign Up</StyledButton></StyledP>
                        <br></br>
                        <br></br>
                        <StyledP> <StyledButton onClick={this.routeChangeLogIn}>Log In</StyledButton></StyledP>
                    </StyledDiv>
                </Card>
            </div>
        )
    }
}


