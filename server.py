import socket
import openai

openai.api_key = "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"


class Server:

    def __init__(self, port):
        self.socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.socket.bind(('localhost', port))
        self.socket.listen(1)
        self.context = None

    def run(self):
        while True:

            clientSocket, address = self.socket.accept()
            print('Received connection from', address)

            while True:
                message = clientSocket.recv(1024)
                if message == 'exit':
                    break
                print('Received message:', message)

                message_string = message.decode()
                
                if self.context:
                    # Si hay contexto, agregarlo al mensaje del usuario
                    message_string = self.context + " " + message_string

                messages = [{"role": "system", "content": "Sistema: Eres un asistente nutricional del preventorio de La Ensenada. Tu funcion es ayudar a los nutricionistas en sus tares diarias en el preventorio para que el nutricionista cumpla con sus objetivos, los cuales son ayudar a las personas para controlar su peso, prevenir enfermedades relacionados con la nutrición y brindar una dieta adecuada. Solo responde cosas relacionados a la nutrición y salud en general, nada de otras áreas."},
                            {"role": "user", "content": message_string}]

                
                response = openai.ChatCompletion.create(
                    model="gpt-3.5-turbo",
                    messages=messages,
                    max_tokens=1024,
                    temperature=0.2
                )

                self.context = response.choices[0].message.content
                
                clientSocket.sendall(response.choices[0].message.content.encode())

            clientSocket.close()

if __name__ == '__main__':
    server = Server(8080)
    server.run()
