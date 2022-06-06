package guestbook.service;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import guestbook.entity.Guestbook;

public class JPAService {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	public JPAService() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("demo");
		}
		em = emf.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	// 查詢多筆
	public List<Guestbook> queryGuestbook(){
		// JPQL 所指的 Guestbook 是 entity 的名字而非 table name
		// 所以本題 select g from Guestbook g 成功
		//        select g from guestbook g 失敗
		Query query = em.createQuery("select g from Guestbook g"); // JPQL
		return query.getResultList();
	}
	
	// 新增
	public void addGuestbook(Guestbook guestbook) {
		synchronized (em) {
			EntityTransaction etx = em.getTransaction();
			etx.begin(); // 開始
			em.persist(guestbook); // 存入 guestbook
			etx.commit(); // 提交
		}
	}
	
	// 查詢單筆
	public Guestbook getGuestbookById(Integer id) {
		return em.find(Guestbook.class, id);
	}
	
	// 修改
	public void updateGuestbook(Guestbook guestbook) {
		synchronized (em) {
			if(getGuestbookById(guestbook.getId()) != null) {
				EntityTransaction etx = em.getTransaction();
				etx.begin(); // 開始			
				// 使用 merge 注意事項:
				// 1) 若該筆資料在資料庫不存在，會變成新增!!!
				// 2) 若該筆資料不存在，會變成修改!!!
				em.merge(guestbook); // 存入/修改 guestbook
				etx.commit(); // 提交	
			}
			
		}		
	}

	// 刪除
	public void deleteGuestbookById(Integer id) {
		synchronized (em) {
			EntityTransaction etx = em.getTransaction();
			etx.begin(); // 開始
			
			Guestbook guestbook = getGuestbookById(id);
			if(guestbook != null) {
				em.remove(guestbook);
			}
			
			etx.commit(); // 提交
		}		
	}	
	
	
}
