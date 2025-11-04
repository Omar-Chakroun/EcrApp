import socket

def start_server(host='0.0.0.0', port=5000):
    # Create a socket object
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Bind the socket to the address and port
    server_socket.bind((host, port))

    # Start listening for incoming connections
    server_socket.listen(5)
    print(f"Server listening on {host}:{port}")

    while True:
        try:
            # Accept a new connection
            client_socket, addr = server_socket.accept()
            print(f"Connection from {addr}")

            while True:
                # Receive data from the client
                data = client_socket.recv(1024)
                
                if not data:
                    break  # Break the loop if no data is received

                print(f"Received data: {data.rstrip()}")

                # Optionally, send a response back to the client
                response = "Registration command received"
                client_socket.send(response.encode('utf-8'))

            # Close the connection
            client_socket.close()
            print(f"Connection with {addr} closed.")

        except Exception as e:
            print(f"An error occurred: {e}")
            break

    # Close the server socket
    server_socket.close()

if __name__ == "__main__":
    start_server()
