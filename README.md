# EduStream: E-Learning Platform

EduStream is an e-learning platform developed using Java Swing for the frontend and Python for backend video conferencing integration. The platform allows teachers to upload content, start video calls, and students to access uploaded materials and join video calls. The system supports role-based access for Teachers, Students, and Admins, with specific functionalities for each role.

## Features

- **Teacher Menu:**
  - Upload content (files) for the class.
  - Start a video call for the selected classroom.
  - Option to upload content and start a video call simultaneously.

- **Student Menu:**
  - View uploaded content for the selected classroom.
  - Join a video call for the selected classroom.

- **Admin Menu:**
  - Admin panel with controls (future implementations).

- **File Uploading:**
  - Allows teachers to upload content to the platform which students can later access.
  - The uploaded files are stored in a dedicated directory (`uploads`).

- **Video Call Integration:**
  - Integrates with Jitsi Meet for video calls, allowing users to join calls by classroom code.

## Technologies Used

- **Java Swing:** Used for the user interface to provide a responsive and interactive design.
- **Python (Backend):** For integrating video call functionality (through Jitsi Meet).
- **Jitsi Meet:** Open-source video conferencing tool for video calls.
- **File System:** Local file storage system to upload and list content.

## Usage

### Teacher Login:
- Upload content and start video calls for classrooms using the Teacher Menu.

### Student Login:
- View uploaded files and join video calls using the Student Menu.

### Admin Panel:
- Admin controls will be added in future versions of the platform.

## Contributing

Feel free to fork this project and submit pull requests for any improvements or bug fixes. Here's how you can contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a pull request.

## Acknowledgements

- Jitsi Meet for the video calling integration.
- Java Swing for the desktop application UI.
- GitHub for version control and collaboration.

## Future Improvements

- **Admin Controls**: The admin menu will include features for managing users, uploaded content, and classroom configurations.
- **Enhanced Video Calling**: Integration with a more advanced video calling service and additional features like screen sharing.
- **Database Integration**: Future implementation of a database for user management and content storage.

## Credits

Created by Shashank Singh and Anushka Banerjee

## Clone the repository:
   ```bash
   git clone https://github.com/yourusername/edustream.git
