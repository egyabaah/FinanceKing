import http from "../http-common";

class AccountService {
 getAll() {
    return http.get("/account");
  }

  get(id) {
    return http.get(`/account/${id}`);
  }

  create(data) {
    return http.post("/account", data);
  }

  update(id, data) {
    return http.put(`/account/${id}`, data);
  }

  delete(id) {
    return http.delete(`/account/${id}`);
  }

  deleteAll() {
    return http.delete(`/account`);
  }

  findByTitle(title) {
    return http.get(`/account?title=${title}`);
  }
}

export default new AccountService();