package com.example.Users.repository;

import java.util.List;

import com.example.Users.models.userOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userOrdersRepository extends JpaRepository<userOrders, Long> {

    @Query(value = "Select coalesce(min(price),0) from userOrders where type = '2' and status = '1' and id_stocks = ?1", nativeQuery = true)
    Double selecionaMenorPrecoVenda(Long id_stocks);

    @Query(value = "Select coalesce(max(price),0) from userOrders where type = '2' and status = '1' and id_stocks = ?1", nativeQuery = true)
    Double selecionaMaiorPrecoVenda(Long id_stocks);

    @Query(value = "Select coalesce(min(price),0) from userOrders where type = '1' and status = '1' and id_stocks = ?1", nativeQuery = true)
    Double selecionaMenorPrecoCompra(Long id_stock);

    @Query(value = "Select coalesce(max(price),0) from userOrders where type = '1' and status = '1' and id_stocks = ?1", nativeQuery = true)
    Double selecionaMaiorPrecoCompra(Long id_stock);

    @Query(value = "select * from userOrders uo where uo.id_user <> :id_user and uo.id_stocks = :id_stock and uo."type"  <> :type and uo.status=1", nativeQuery = true)
    List<userOrders> tipoEstock(@Param("type") int type, @Param("id_stock") long id_stock,
            @Param("id_user") long id_user);

    @Query(value = "SELECT * FROM userOrders WHERE id_user = ?1", nativeQuery = true)
    List<userOrders> buscaByuser(int idUser);

    @Query(value = "SELECT * FROM userOrders WHERE id = ?1", nativeQuery = true)
    userOrders encontraId(long id);// findId

    @Query(value = "SELECT * FROM userOrders WHERE id_user = ?1 and type = ?2", nativeQuery = true)
    List<userOrders> encontraUserEtipo(int idUser, int type);// findByUserIdAndType

    @Query(value = "SELECT * FROM userOrders where status=1 and type=1", nativeQuery = true)

    List<userOrders> buscaStatus();

    @Query(value = "SELECT * FROM userOrders where  type:=1", nativeQuery = true)
    List<userOrders> encontraEmail2(String email, int type);

}