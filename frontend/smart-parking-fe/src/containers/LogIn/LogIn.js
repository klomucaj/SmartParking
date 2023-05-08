import React, { useState, useEffect } from 'react';
import { Form, Input, Select, Checkbox, Button, Row, Col, PageHeader } from "antd"
import { useStoreState, useStoreActions } from "easy-peasy";
import styled from "@xstyled/styled-components";
import "antd/dist/antd.css";
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import { Link } from 'react-router-dom';


export const LogIn = () => {

    const [form] = Form.useForm();
    const [, forceUpdate] = useState({}); // To disable submit button at the beginning.

    useEffect(() => {
        forceUpdate({});
    }, []);


    const usersStore = useStoreState((state) => state.users);

    const { checkUser } = useStoreActions(actions => ({
        checkUser: actions.users.checkUser
    }));


    const onFinish = async (values) => {
        console.log('Received values of form: ', values);

        const userData = {
            email: values.username,
            password: values.password,
        };

        await checkUser(userData)

        console.log("userData", userData)
        console.log("usersStore.userData: ", usersStore.userData)

    };


    
};

const SubTitle = styled.div`
    width: 217px;
    height: 31px;
    margin: 0 108px 42px 17px;
    font-family: BerlinSansFBDemi;
    font-size: 30px;
    font-weight: bold;
    font-stretch: normal;
    font-style: normal;
    line-height: normal;
    text-align: center;
    color: #14a7ac;

`;


const StyledButton = styled(Button)`
    border-radius: 15px;
    background-image: linear-gradient(to top, #14a7ac, #14a7ac);
    width: 70%;
`;
