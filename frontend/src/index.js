import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import { Provider } from "react-redux"; // Redux Provider
import store from "./redux/store/store"; // Import the store
import App from "./App";
import './index.css';

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(
  <Provider store={store}> {/* Wrap the app in Redux Provider */}
    <BrowserRouter future={{ v7_relativeSplatPath: true }}>
      <App />
    </BrowserRouter>
  </Provider>
);
