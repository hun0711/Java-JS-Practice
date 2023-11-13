import React from 'react';
import './Menubar.css';

const Menubar = () => {
  return (
    <>
 {/* 메뉴바 */}
 <div className="black-nav">
        <div
          style={{
            marginTop: 10,
            padding: 10,
            fontWeight: 600,
            fontSize: 25,
          }}
        >
          My World
        </div>

        <div className="separator" />
        <div
          style={{
            marginTop: 20,
            padding: 10,
            alignItems: "center",
            fontWeight: 600,
            fontSize: 18,
          }}
        >
          로그인
        </div>
        <div className="separator" />

        <div className="category">
          <div>TODAY</div>
          <div>PLAYLIST</div>
          <div>REVIEW</div>
          <div>TRAINING</div>
          <div>PHOTO</div>
        </div>

        <div style={{ display: "flex", marginTop: 200 , fontWeight:600 , fontSize:15}}>
          <div style={{ marginRight: 10 }}>깃주소</div>
          <div>로그아웃</div>
        </div>
      </div>

    </>
  )
}

export default Menubar