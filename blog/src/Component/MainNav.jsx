import React from "react";
import { Button } from "react-bootstrap";

function MainNav() {
  return (
    <>
    <div className="main-nav container">
    <Button variant="primary">일정</Button>{' '}
    <Button variant="primary">날씨</Button>{' '}
    <Button variant="primary">새 소식</Button>{' '}
    </div>
    </>
  );
}

export default MainNav;
