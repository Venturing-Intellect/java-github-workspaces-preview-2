import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Toast, ToastContainer } from 'react-bootstrap';

function App() {
  const [email, setEmail] = useState('');
  const [feedbackText, setFeedbackText] = useState('');
  const [name, setName] = useState('');
  const [showToast, setShowToast] = useState(false);
  const [toastMessage, setToastMessage] = useState('');
  const [toastVariant, setToastVariant] = useState('success');

  const handleSubmit = async (event) => {
    event.preventDefault();
    const feedback = { email, feedbackText, name };

    try {
      const response = await fetch('http://localhost:8080/feedback', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(feedback),
      });

      if (response.ok) {
        setToastMessage('Feedback submitted successfully!');
        setToastVariant('success');
        setEmail('');
        setFeedbackText('');
        setName('');
      } else {
        setToastMessage('Failed to submit feedback.');
        setToastVariant('danger');
      }
    } catch (error) {
      setToastMessage('An error occurred while submitting feedback!');
      setToastVariant('danger');
    } finally {
      setShowToast(true);
    }
  };

  return (
    <div className="container mt-5">
      <h1>Submit Feedback</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="email">Email address</label>
          <input
            type="email"
            className="form-control"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input
            type="text"
            className="form-control"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="feedbackText">Feedback</label>
          <textarea
            className="form-control"
            id="feedbackText"
            rows="3"
            value={feedbackText}
            onChange={(e) => setFeedbackText(e.target.value)}
            required
          ></textarea>
        </div>
        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>
      <ToastContainer position="top-end" className="p-3">
        <Toast
          onClose={() => setShowToast(false)}
          show={showToast}
          delay={3000}
          autohide
          bg={toastVariant}
        >
          <Toast.Body>{toastMessage}</Toast.Body>
        </Toast>
      </ToastContainer>
    </div>
  );
}

export default App;
