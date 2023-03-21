import http from "../http-common";

class userService {
 getAll() {
    return http.get("/user");
  }

 logIn(data) {
    return http.post("user/authenticate", data);
  }

  get(id) {
    return http.get(`/user/${id}`);
  }

  create(data) {
    return http.post("user/register", data);
  }

  update(id, data) {
    return http.put(`/user/${id}`, data);
  }

  delete(id) {
    return http.delete(`/user/${id}`);
  }

  deleteAll() {
    return http.delete(`/user`);
  }

  findByTitle(title) {
    return http.get(`/user?title=${title}`);
  }
}

export default new userService();