//
//  ViewController.swift
//  UpDownGame
//
//  Created by WhiteKr on 2021/09/13.
//

import UIKit

class ViewController: UIViewController {
    
    var randomValue: Int = 0
    var tryCount: Int = 0
    @IBOutlet weak var slider: UISlider!
    @IBOutlet weak var tryCountLabel: UILabel!
    @IBOutlet weak var sliderValueLabel: UILabel!
    @IBOutlet weak var minimunValueLabel: UILabel!
    @IBOutlet weak var maximunValueLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        slider.setThumbImage(#imageLiteral(resourceName: "slider_thumb"), for: .normal)
        reset()
    }
    
    @IBAction func sliderValueChanged(_ sender: UISlider) {
        let intValue: Int = Int(sender.value)
        sliderValueLabel.text = String(intValue)
    }
    
    @IBAction func touchUpHitButton(_ sender: UIButton) {
        let hitValue: Int = Int(slider.value)
        slider.value = Float(hitValue)
    }
    
    @IBAction func touchUpResetButton(_ sender: UIButton) {
        reset()
    }
    
    func reset() {
        print("reset!")
        randomValue = Int.random(in: 0...30)
        print(randomValue)
        tryCount = 0
        tryCountLabel.text = "0 / 5"
        slider.minimumValue = 0
        slider.maximumValue = 30
        slider.value = 15
        minimunValueLabel.text = String(Int(slider.minimumValue))
        maximunValueLabel.text = String(Int(slider.maximumValue))
        sliderValueLabel.text = String(Int(slider.value))
    }

}

