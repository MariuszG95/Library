package core.services;

import data.model.User;
import data.repositories.BookRepository;
import data.repositories.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BorrowService {

    private BorrowRepository borrowRepository;

    @Autowired
    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }
}
